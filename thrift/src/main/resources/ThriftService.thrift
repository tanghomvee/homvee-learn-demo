namespace java com.homvee.thrift
service ThriftService {
  bool testBoolean(1:bool para);
  byte testByte(1:byte para);
  i16 testShort(1:i16 para);
  i32 testInt(1:i32 para);
  i64 testLong(1:i64 para);
  double testDouble(1:double para);
  string testString(1:string para);
  list<string> testList(1:list<string> para);
  map<string,string> testMap(1:map<string,string> para);
  set<string> testSet(1:set<string> para);
  ThriftException testException(1:ThriftException para);
  //ThriftService testService(1:ThriftService para);
  JavaBean testStruct(1:JavaBean para);
 }
 struct JavaBean {
 1:i32 age;
 2:string name;
 }
 exception ThriftException {
 1:string msg;
 }