#include <SoftwareSerial.h>
#include <LiquidCrystal.h>
#include <SeeedRFID.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

#define RFID_RX_PIN 6
#define RFID_TX_PIN 7

#define TEST

SeeedRFID RFID(RFID_RX_PIN, RFID_TX_PIN);
RFIDdata tag;
String dadoTag;

void setup() {
  lcd.begin(16, 2);
  Serial.begin(9600);
  Serial.println("Hello, double bk!");
  lcd.clear();
  lcd.setCursor(3 ,0);
  lcd.print("Bem vindo!");
  lcd.setCursor(0, 1);
  lcd.print("Sistema compras!");
  delay(2000);
  lcd.print("Esperando tag...");
}

void loop() { 
  if(RFID.isAvailable()){
    tag = RFID.data();
    Serial.print("Numero da tag: ");
    Serial.println(RFID.cardNumber());
    lcd.clear(); //Limpa Display
    lcd.setCursor(6, 0); //posiciona cursor na coluna 6, linha 0
    lcd.print("Numero da Tag:");
    lcd.setCursor(0, 1);
    lcd.print(RFID.cardNumber());
    delay(5000);
#ifdef TEST
  lcd.clear();
  lcd.setCursor(0, 0);
  Serial.print("Dado da tag: ");
  lcd.print("Dado: ");
  for(int i=0; i<tag.dataLen; i++){
      lcd.setCursor(0, 1);
      lcd.print(tag.raw[i], HEX);
      Serial.print(tag.raw[i], HEX);
      dadoTag = (tag.raw[i], HEX);
      Serial.print('\t');
    }
#endif
  }
}
