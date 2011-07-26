struct Something
{
  1: string foo,
  2: i32 bar
}

exception FooException {
    1: string message,
}

service Foo {
  Something bar(1: string arg) throws (1: FooException fe)
}
