(:
What stock has the 2nd greatest price value?
:)

<gabagoo>
{
let $file := "./data/stocks.xml"

for $x in doc($file)//stock
order by xs:float($x/@price) descending
return $x
}
</gabagoo>