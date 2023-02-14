(:
What is the stock symbol with the lowest price? For example if the IBM - Internation Business Machine  has a price 5000.00. Then your answer is IBM. Note a variation of this quesion will used for 5 other question.
:)

<gabagoo>
{
let $file := "./data/stocks.xml"

for $x in doc($file)//stock
order by xs:float($x/@price)
return $x
}
</gabagoo>