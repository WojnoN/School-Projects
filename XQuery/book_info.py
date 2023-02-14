import xml.etree.ElementTree as ET

def convert_numbers(attrib,fields):
    for f in fields:
        attrib[f] = float(attrib[f])
    return

def calculate_average_price(attrib):
    attrib["taxPaid"] = (attrib["end"] - attrib["start"]) * attrib["taxRate"]
    return

def calculate_total_price(attrib):
    attrib["taxPaid"] = (attrib["end"] - attrib["start"]) * attrib["taxRate"]
    return


def get_books_info():
    tree = ET.parse('data/w3.books.xml')
    root = tree.getroot()
    developer = "Wojno, Nicholas"
    greatest = 0.0
    least = 100000000
    total = 0.0
    books = []
    number = 0

    for child in root:
        for element in child.iter('price'):
            price = float(element.text)
            if price < least:
                least = price
            if price > greatest:
                greatest = price
            total += price
            books.append(element.text)

    average = total / len(books)

    return {"average": ("%.2f" % average), "total": ("%.2f" % total), "highest": greatest, "developer": developer, "lowest": least}

def get_books():
    tree = ET.parse('data/w3.books.xml')
    root = tree.getroot()
    test = []
    for child in root:
        test.append(child.tag)

    return test

if __name__ == '__main__':

    tree = ET.parse('data/w3.books.xml')
    root = tree.getroot()
    for child in root:
        for element in child.iter('price'):
            print(element.text)

    book_info = get_books_info()
    #books = get_books()
    print(get_books())
