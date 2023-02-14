(:
How many stocks are stocks.xml file?
:)

<gabagoo>
{
let $file := "./data/stocks.xml"
let $x := doc($file)//stock

return count($x)
}
</gabagoo>