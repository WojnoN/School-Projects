(:
What is the average price  for  Utilities stock company? Display the answer with decimal points, example 413.234  can be written as 413.23.
:)

<gabagoo>
{
let $file := "./data/stocks.xml"
let $x := doc($file)//stock[@sector="Utilities"]

return avg($x/@price)
}
</gabagoo>