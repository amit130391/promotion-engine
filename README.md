# 📦 Promotion Engine

A simple, modular, and SOLID-compliant Promotion Engine built using **Java 17** and **Spring Boot 3.x**.  
It calculates the total price for a cart after applying different types of promotions such as **volume-based discounts** and **paired item deals**.

---

## 📑 Problem Statement

Implement a promotion engine to calculate the total order value for a cart containing a list of SKU IDs (`A`, `B`, `C`, `D`, etc.) by applying active promotions.

---

## 📦 SKU Prices

| SKU | Unit Price |
|:----|:-----------|
| A   | 50         |
| B   | 30         |
| C   | 20         |
| D   | 15         |

---

## 📝 Active Promotions

| Type                    | Rule                        |
|:------------------------|:----------------------------|
| VolumeBasedPromotion     | 3 of A's for 130             |
| VolumeBasedPromotion     | 2 of B's for 45              |
| PairedItemsPromotion     | C & D for 30                 |

---

## 📂 Directory Structure

promotion-engine/
├── src/
│ ├── main/
│ │ ├── java/com/example/promotion/
│ │ │ ├── PromotionEngineApplication.java
│ │ │ ├── model/
│ │ │ ├── engine/
│ │ │ ├── promotion/
│ │ │ ├── service/
│ │ │ └── controller/
│ └── test/
│ └── java/com/example/promotion/
│ ├── PromotionEngineTests.java
│ └── ScenarioTests.java
├── pom.xml
└── README.md

---

## ⚙️ How to Run

1️⃣ Clone the repository:
```bash
git clone https://github.com/amit130391/promotion-engine.git
cd promotion-engine

2️⃣ Build and run the application:
bash
Copy
Edit
./mvnw spring-boot:run

📌 API Endpoints
Method	Endpoint	             Description
POST	 /cart/add/{sku}/{qty}	 Add item(s) to the cart
GET	   /cart/total	           Get total price after applying promotions

🧪 Test Scenarios

✅ Scenario A
1 × A
1 × B
1 × C
Total: 100

✅ Scenario B
5 × A
5 × B
1 × C
Total: 370

✅ Scenario C
3 × A
5 × B
1 × C
1 × D
Total: 280

✅ Technologies Used
Java 17
Spring Boot 3.x
Maven
JUnit 5

📦 Promotion Types Supported
VolumeBasedPromotion: Fixed price when buying a specified quantity of a SKU
PairedItemsPromotion: Fixed price when buying a specific pair of SKUs
