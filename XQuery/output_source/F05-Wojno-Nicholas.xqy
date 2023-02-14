(:
What  is the average dividend payment, remove all the stocks that pay 0 dividends ?

So admittedly, I wasn't sure  how to extract the payment into a single number for average, so I took the reuslts of the 1st xquery function and placed them into a 3rd
party website and then took the average in a calculator.
https://miniwebtool.com/sum-calculator/ <- let me use the spaces as a breaker after getting the sum of all the payments then divided by the count received in the 2nd query

Overall, this code is very wonky and I haven't a clue how it works fully quite frankly. Because without the comment, I can't do both queries, but it still reads both queries.

At least I still ended up with the answer of 2.22 after getting a sum of 886.2498699, rounding to 886.25 then dividing by 400

soo 886.25 / 400 = 2.215, rounded up and got 2.22
:)

<gabagoo>
(:

{
let $file := "./data/stocks.xml"

for $x in doc($file)//stock
where $x/@dividends != 0
let $y := $x/@dividends * $x/@price

return $y
}
:)

{
let $file := "./data/stocks.xml"
let $x := doc($file)//stock[@dividends!=0]
let $a := $x/price
let $b := sum(xs:float($x/@dividends))
let $c := $a * $b
return count($x)
}



</gabagoo>
