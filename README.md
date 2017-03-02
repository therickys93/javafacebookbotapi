# Java Facebook Bot API

This Api is written for my personal use.

## Facebook Challenge ( using Restlet )

```
@GET
public String acceptChallenge() throws IOException {
	Map<String, String> challenge = getQuery().getValuesMap();
	Hub hub = new Hub(challenge);
	return hub.challenge();
}
```