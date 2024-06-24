## _Description_

Application has the following features

```bash
1 - CURD operation on User and Role
2 - For active users generate jwt access_token & refresh_token
3 - Generate refresh_token when access_token expire
```

## _Pre-requite_

```bash
1 - Need my SQL databse
3 - Need JDK 11
2 - Need any IDE
```

## _swagger url_

```python
http://localhost:8081/swagger-ui.html
```

## _endpoint url_

```python
GET localhost:8081/api/login?userName=user&password=pwd
GET localhost:8081/api/token/refresh
POST localhost:8081/api/user/save
POST localhost:8081/api/role/save
POST localhost:8081/api/add/to/user

```

## _Contributing_

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

contact : goodyshweta@gmail.com

