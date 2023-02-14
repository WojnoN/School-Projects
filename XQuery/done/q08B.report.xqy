<books>
{
let $file := "./data/simplebooks.xml"
for $x in doc($file)//book
order by $x
return $x
}
</books>