(:
What is the highest price paid for stock?  Use price attribute to calculate the maximum value.
:)

<gabagoo>
{
let $file := "./data/stocks.xml"

for $x in doc($file)//stock
order by xs:float($x/@price) descending
return $x
}
</gabagoo>