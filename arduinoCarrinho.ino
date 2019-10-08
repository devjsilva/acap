#include <SoftwareSerial.h>
#include <LiquidCrystal.h>
#include <SeeedRFID.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

#define RFID_RX_PIN 2
#define RFID_TX_PIN 3

#define TEST

SeeedRFID RFID(RFID_RX_PIN, RFID_TX_PIN);
RFIDdata tag;

void setup() {
  lcd.begin(16, 2);
  Serial.begin(9600);
  Serial.println("Hello, double bk!");
  lcd.clear();
  lcd.setCursor(3 ,0);
  lcd.print("Bem vindo!");
  lcd.setCursor(0, 1);
  lcd.print("Sistema compras");
}

void loop() { 
  if(RFID.isAvailable()){
    tag = RFID.data();
    Serial.print("RFID card number: ");
    Serial.println(RFID.cardNumber());
    lcd.clear(); //Limpa Display
    lcd.setCursor(6, 0); //posiciona cursor na coluna 6, linha 0
    lcd.print("ACAP");
    lcd.setCursor(0, 1);
    lcd.print("Esperando Tag...");
    delay(5000);
#ifdef TEST
  Serial.print("RFID raw data: ");
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Dado: ");
  for(int i=0; i<tag.dataLen; i++){
      lcd.setCursor(0, 1);
      lcd.print(tag.raw[i], HEX);
      Serial.print(tag.raw[i], HEX);
      Serial.print('\t');
    }
#endif
  }
}
