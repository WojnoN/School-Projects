(:
What stock symbol pays the highest dividends?
:)

<gabagoo>
{
let $file := "./data/stocks.xml"

for $x in doc($file)//stock
order by xs:float($x/@dividends) descending
return $x
}
</gabagoo>