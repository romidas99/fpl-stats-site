# ⚽ PremierZone

PremierZone is a full-stack project that scrapes and analyzes match statistics for 700+ players, stores them in a PostgreSQL database, and exposes them through a Spring Boot backend with a ReactJS frontend. It also includes a machine learning pipeline that predicts match outcomes based on historical data.

---

## ✨ Features

- **Data Scraping**  
  Collects comprehensive match statistics for 700+ players using Python and `pandas`.

- **Backend (Spring Boot)**  
  Provides REST APIs to query, manipulate, and serve match data in real-time.

- **Database (PostgreSQL)**  
  Stores raw and processed statistics with support for dynamic SQL queries.

- **Frontend (ReactJS)**  
  Clean, intuitive UI for browsing players, matches, and prediction results.

- **Machine Learning (scikit-learn)**  
  Trains models to predict match outcomes using scraped datasets and engineered features.

---

## 🛠️ Tech Stack

- **Frontend:** ReactJS, TailwindCSS
- **Backend:** Spring Boot (Java)
- **Database:** PostgreSQL
- **Data Processing:** Python, pandas, NumPy
- **Machine Learning:** scikit-learn

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Node.js 18+ & npm / yarn
- Python 3.10+ with `pandas`, `scikit-learn`
- PostgreSQL 14+

### Clone the Repository
```bash
git clone https://github.com/romidas99/fpl-stats-site.git
cd fpl-stats-site
