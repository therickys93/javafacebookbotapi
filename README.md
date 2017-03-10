# Java Facebook Bot API

This Api is written for my personal use and so it does not have all the features.
If you want to make some changes feel free to fork and use it.

## Facebook Developers Page configuration

In the page where you create the app you need to set the webhook and what your bot is going to accept.
This implementation of the bot api works only with the "messages" and "messages_postbacks" webhook.

## Facebook Challenge ( using Restlet )

```
@GET
public String acceptChallenge() throws IOException {
	Map<String, String> challenge = getQuery().getValuesMap();
	Hub hub = new Hub(challenge, VERIFY_TOKEN);
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

I don't use standard repositories so you have to use Jitpack.

* First in your root build.gradle file add this:

```
allprojects {
        repositories {
                ...
                maven { url 'https://jitpack.io' }
        }
}
```

* Finally in your dependencies add: ( this is only a thought )

```
compile 'com.github.therickys93:javafacebookbotapi:0.1.0'
```
