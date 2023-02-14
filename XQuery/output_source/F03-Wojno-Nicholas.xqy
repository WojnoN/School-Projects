(:

:)

<gabagoo>
{
let $file := "./data/stocks.xml"
let $x := doc($file)//stock[@sector="Utilities"]

return count($x)
}
</gabagoo>