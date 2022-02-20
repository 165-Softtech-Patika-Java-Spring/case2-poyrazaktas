# Case2

## Adres Kayıt Sistemi:  
Bir adreste bulunması gereken alanlar:  
- Ülke ✔️
- Şehir ✔️
- İlçe ✔️
- Mahalle ✔️
- Sokak ✔️
- Kapı No  ✔️
- Daire No ✔️

Bir adet controller yazınız(Tek controller yeterli). Bu controller içerisinde aşağıdaki işlemler yapılabilmelidir.

1. Ülke kaydedilebilmelidir. ✔️
2. Ülke kodundan ülke sorgulanabilmelidir. ✔️
3. Şehir kaydedilebilmelidir. ✔️
4. Plakadan şehir bilgisi sorgulanabilmelidir.✔️
5. İlçe  kaydedilebilmelidir. ✔️
6. Bir ile ait ilçeler sorgulanabilmelidir.✔️
7. Mahalle kaydedilebilmelidir. ✔️
8. Mahalle adını güncellenebilmelidir.  ✔️
9. Bir ilçeye ait mahalleler sorgulanabilmelidir. ✔️
10. Sokak kaydedilebilmelidir. ✔️
11. Sokak adı güncellenebilmelidir. ✔️
12. Bir mahalleye ait sokaklar sorgulanabilmelidir.✔️
13. Adres kaydedilebilmelidir.  ✔️
14. Adres silinebilmelidir. ✔️
15. Id den adres bilgisi edinilebilmelidir. ✔️

### NOT:  
- Address entitysi hariç diğer entitylerin servislerinde entity kullanabilirsiniz. Yani metot parametresi için dto, return için başka bir dto kullanmanıza gerek yok.  
- Address kaydeden dönen vs yerlerde mapper ya da converterlar kullanarak DTO ile veri akışını sağlayınız.


### Benim Ödevimdeki Farklılıklar ⚙️
- Birden fazla controller kullandım.
- OneToMany, ManyToOne ilişkileri kullandığım için ilgili controller'dan GET isteği ile alt sınıflar çekilebilmektedir

**Örneğin:** *GET DISTRICTS* ile tüm ilçeler mahalleleri ile birlikte gelir:
```json
[
  {
    "name": "pendik",
    "city": {
      "id": 1,
      "name": "istanbul",
      "licensePlate": 34,
      "country": {
        "id": 1,
        "name": "türkiye",
        "countryCode": 1
      }
    },
    "neighborhoodList": [
      {
        "id": 1,
        "name": "yenişehir mah",
        "district": {
          "id": 1,
          "name": "pendik",
          "city": {
            "id": 1,
            "name": "istanbul",
            "licensePlate": 34,
            "country": {
              "id": 1,
              "name": "türkiye",
              "countryCode": 1
            }
          }
        }
      }
    ]
  },
  {
    "name": "kartal",
    "city": {
      "id": 1,
      "name": "istanbul",
      "licensePlate": 34,
      "country": {
        "id": 1,
        "name": "türkiye",
        "countryCode": 1
      }
    },
    "neighborhoodList": [
      {
        "id": 2,
        "name": "yakacık mah",
        "district": {
          "id": 2,
          "name": "kartal",
          "city": {
            "id": 1,
            "name": "istanbul",
            "licensePlate": 34,
            "country": {
              "id": 1,
              "name": "türkiye",
              "countryCode": 1
            }
          }
        }
      }
    ]
  },
  {
    "name": "kadıköy",
    "city": {
      "id": 1,
      "name": "istanbul",
      "licensePlate": 34,
      "country": {
        "id": 1,
        "name": "türkiye",
        "countryCode": 1
      }
    },
    "neighborhoodList": []
  }
]
```
- Plaka kodundan şehir sorgulama *CtyCityController* içerisinde, Ülke kodundan ülke sorgulama ise *CntCountryController* içerisinde yer almaktadır.
