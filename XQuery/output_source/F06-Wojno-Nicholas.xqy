(:
How many Utilties company are in this list and have a price greater than 100.00 ?
:)

<gabagoo>
{
let $file := "./data/stocks.xml"
let $x := doc($file)//stock[@sector="Utilities" and @price>100]
return count($x)
}
</gabagoo>