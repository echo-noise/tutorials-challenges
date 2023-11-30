import pandas as pd
import matplotlib.pyplot as plt
from math import sqrt
import matplotlib.gridspec as gridspec

class Line(object):
    def __init__(self, name="", a=0, b=0):
        self.name = name
        self.a = a
        self.b = b
        self.y = []

    def __str__(self):
        return f"{self.name} = {self.a}x + {self.b}"

    def f(self, x):
        return (self.a * x) + self.b

    def find_a(self, x, y):
        sx = x.std()
        sy = y.std()
        r = x.corr(y)
        self.a = r * (sy/sx)

    def find_ab_squares(self, x, y):
        self.find_a(x, y)
        xbar = x.mean()
        ybar = y.mean()
        self.b = ybar - (self.a * xbar)

    # y array for batch of x values
    def predict(self, x):
        self.y = []
        for xi in x:
            self.y.append(self.f(xi))

    def dlda(self, x, loss):
        return -2 * x * loss

    def dldb(self, loss):
        return -2 * loss

    def descent_step(self, x, y, step):
        dlda = 0.0
        dldb = 0.0
        for xi, yi in zip(x, y):
            current_loss = self.loss(xi,yi)
            dlda += self.dlda(xi, current_loss)
            dldb += self.dldb(current_loss)
        self.a -= step * (1 / x.shape[0]) * dlda
        self.b -= step * (1 / x.shape[0]) * dldb

    def loss(self, x, y):
        return y - self.f(x)

    def sum_square_errors(self, x, y):
        sum_square_errors = 0
        for xi, yi in zip(x, y):
            sum_square_errors += self.loss(xi, yi)
        return sum_square_errors


FILENAME = "Student Study Hour V2.csv"
col_x = "Hours"
col_y = "Scores"
csv = pd.read_csv(FILENAME, usecols=[col_x, col_y])
x_values = csv[col_x]
y_values = csv[col_y]

prediction = Line(name="f(x)")
prediction.find_ab_squares(x_values, y_values)
prediction.predict(x_values)

print(f'samples: {x_values.shape[0]}')

gradient = Line(name="g(x)")
lr = 0.01
iterations = 0

while gradient.sum_square_errors(x_values, y_values) > 0.01:
  gradient.descent_step(x_values, y_values, lr)
  iterations += 1

gradient.predict(x_values)

figure = plt.figure(layout="constrained")
figure.suptitle('Result')

grid = figure.add_gridspec(ncols=2,nrows=2,hspace=0)

ax1 = figure.add_subplot(grid[0,:])
ax1.set_title('Comparison between lines')
ax1.plot(x_values, prediction.y, c='r')
ax1.plot(x_values, gradient.y, 'g--', linewidth=1)

ax2 = figure.add_subplot(grid[1,0])
ax2.set_title(f'Least Squares, {prediction}',fontsize=9)
ax2.plot(x_values, prediction.y, c='r')

ax3 = figure.add_subplot(grid[1,1])
ax3.set_title(f'Gradient descent, {gradient}',fontsize=9)
ax3.plot(x_values, gradient.y, c='g')

for ax in figure.axes:
    ax.scatter(x_values, y_values)

plt.ticklabel_format(style="plain")
plt.show()