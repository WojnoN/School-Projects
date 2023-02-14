(:
How many stocks cost more than the average stock price?
:)

<gabagoo>
{
let $file := "./data/stocks.xml"
let $x := doc($file)//stock
let $z := avg($x/@price)
let $y := doc($file)//stock[@price>xs:integer($z)]


return count($y)
}
</gabagoo>