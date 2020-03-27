# Spring-Boot-Simple-Web-Application

Projede neler var ? 
Bu projede iki farklı rol üzerinden belli işlemlerin gerçekleştirilmesi sağlanmıştır. ADMIN ve USER rolleri bulunmaktadır.
Projeye çalıştırdıktan sonra sizi http://localhost:8080/login ekranına atacak ve oradan kullanıcı adı ve şifrenizi girebilirsiniz. 
ADMIN rolüne sahip tek bir kullanıcı vardır. 
admin@admin.com şifresi 12345 yazaraktan girebilirsiniz. 

Eğer yeni üye kayıdı yapmadan admin hesabıyla girerseniz http://localhost:8080/main şu şekilde gelicektir. 


![alt text](https://github.com/firatkaya1/Spring-Boot-Simple-Web-Application/blob/master/src/main/resources/img/resim2.png)

Fakat yeni bir üye kayıdı ile giriş yaptıgınız zaman rol tanımlamanız default olarak USER olacaktır. USER rolüne sahip kullanıcının
arayüzü bu şekilde görünmektedir.

![alt text](https://github.com/firatkaya1/Spring-Boot-Simple-Web-Application/blob/master/src/main/resources/img/resim1.png)

USER rolüne sahip kullanıcıların pek arayüzde pek bir etkinligi yoktur.

POSTMAN aracılığıyla etkileşimde bulunmak için bir token'a sahip olması gerekmektedir. Bu token kayıt olduktan sonra http://localhost:8080/main
adresinde bulunan token degeridir. 

Eğer POSTMAN kullanarak tüm kitapları getirmek istersem 





http//localhost:8080/api/v1/tokenbilgisi/book yazıp GET istegi ile kayıtlı tüm kitapları görebilirsiniz.

Aynı şekilde kayıtlı kullanıcıları görebilmek için 

http//localhost:8080/api/v1/tokenbilgisi/user yazıp GET istegi ile kayıtlı tüm kullanıcıları görebilirsiniz.

Bütün istekler yapılmadan önce tokenbilgisi zorunludur. Tokensiz gelen istekler geçersizdir.

Yapamadıgım nokta ise POSTMAN aracılıgıyla rol yapılarını aktif bir şekilde kullanamadım. Bunun nedeni arayüzümde form tabanlı 
bir giriş varken postmanda ise bu bir sorun teşkil etmekte, buna çözüm olarak Spring Security ayarlarından /api/v1** üzerinden 
gelen tüm istekleri kabul ettirip, metotlarda ise token bilgisi alma şartı koşturarak alternatif bir çözüm getirdim.


NOT : Projede mail doğrulamakta mümkündür. Eğer kayıt olurken mail adresinizi doğru yazarsanız mail adresinize şöyle bir mail alıcaksınız :
http://localhost:8080/confirm?token=tokeniniz 

Linke tıkladıgınız anda metot tetiklenerek verification degerinizi true yapacaktır.


localhost:8080/users ve localhost:8080/books sayfalarının görünümleri aşağıdadır. Default olarak projede hiç bir kitap eklenmesi yapılmamıştır.

![alt text](https://github.com/firatkaya1/Spring-Boot-Simple-Web-Application/blob/master/src/main/resources/img/resim3.png)


![alt text](https://github.com/firatkaya1/Spring-Boot-Simple-Web-Application/blob/master/src/main/resources/img/resim4.png)

