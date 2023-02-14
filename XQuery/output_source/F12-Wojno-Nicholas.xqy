(:

:)

<gabagoo>
{
let $file := "./data/stocks.xml"
let $x := doc($file)//stock
let $z := avg($x/@price)
return $z
}
</gabagoo>