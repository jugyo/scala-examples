struct Something
{
  1: string foo,
  2: i32 bar
}

service Foo {
  Something bar(1: string arg)
}
