import book_info
import marginal_tax
from flask import Flask, request

app = Flask(__name__)


@app.route('/taxsummary')
def get_tax_summary():
    s_code = request.args.get("code", default="SM", type=str)
    n_salary = request.args.get("salary", default = 9_000, type=float)
    tax_summary = marginal_tax.get_tax_paid_summary(s_code, n_salary)
    return tax_summary

@app.route('/booksummary')
def get_book_sommary():
    book_summary = book_info.get_books_info()
    return book_summary

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9215, debug=True)
