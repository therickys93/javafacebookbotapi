# Java Facebook Bot API

This Api is written for my personal use.

## Facebook Developers Page configuration

In the page where you create the app you need to set the webhook and what your bot is going to accept.
This implementation of the bot api works only with the "messages" webhook.

## Facebook Challenge ( using Restlet )

```
@GET
public String acceptChallenge() throws IOException {
	Map<String, String> challenge = getQuery().getValuesMap();
	Hub hub = new Hub(challenge);
	if(hub.ok()) {
		return hub.challenge();
	} else {
		getLogger().warning(Hub.TOKEN_ERROR);
     	return null;
	}
}
```

## Facebook Parse Payload and Response ( using Restlet )

```
@Post
public Representation payload(Representation data) throws IOException {
	String newMessage = data.getText();
	Payload payload = FacebookBotUtils.parsePayload(newMessage);
	String chatId = payload.entry().messaging().senderId();
	String text = payload.entry().messaging().message().text();
	getLogger().info(text);
	// do what you want with the text
	FacebookBot bot = new FacebookBot("TOKEN");
	String response = bot.execute(new SendMessage(chat_id, text));
	getLogger().info(response);
	return null;
}
```

## Use it in gradle

After download the jar file, create a folder in the root of the project named 'libs', add the jar in the new folder and finally add this line in the gradle dependencies

```
compile fileTree(dir: 'libs', include: ['*.jar'])
```