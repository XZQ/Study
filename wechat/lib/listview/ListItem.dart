abstract class ListItem {}

class HeadingItem implements ListItem {
  final String heading;

  HeadingItem(this.heading);
}

class MessageItem implements ListItem {
  final String sender;
  final String body;

  MessageItem(this.sender, this.body);
}

class BaseBean implements ListItem {
  String name;
  int age;
  String content;

  BaseBean(this.name, this.age, this.content);
}
