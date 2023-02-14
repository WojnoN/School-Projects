(:
What is the most expensive Utilities stock company? Answer the question with the stock symbol.
:)

<gabagoo>
{
let $file := "./data/stocks.xml"

for $x in doc($file)//stock
where $x/@sector="Utilities" 
order by xs:float($x/@price) descending
return $x
}
</gabagoo>