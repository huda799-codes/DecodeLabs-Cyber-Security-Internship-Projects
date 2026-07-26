# Cybersecurity & Defensive Logic Projects — DecodeLab Internship

![Java](https://img.shields.io/badge/Language-Java%2017%2B-orange?style=flat-square&logo=openjdk)
![Domain](https://img.shields.io/badge/Domain-Cybersecurity-blue?style=flat-square)
![Program](https://img.shields.io/badge/Internship-DecodeLab%202026-green?style=flat-square)

## 📌 Program Overview
This repository contains four core cybersecurity modules developed during my internship as a Cybersecurity Analyst at **DecodeLab**. The projects transition from core defensive validation logic and custom cryptographic implementations to automated threat triage and system security auditing—all written in **Java**.

---

## 🛠️ Project Summary

### 1. Password Strength Checker (`/project-01-password-strength-checker`)
* **Goal:** Evaluates user passwords for entropy and security compliance[cite: 1].
* **Key Features:**
  * Enforces length constraints ($\ge 8$ characters) and checks for numbers, uppercase letters, and symbols[cite: 1].
  * Evaluates $O(n)$ linear iteration efficiency and character set expansion beyond ASCII into Unicode[cite: 1].
* **Java Concepts Used:** `java.lang.Character`, Regular Expressions (`java.util.regex`), String manipulation.

### 2. Basic Encryption & Decryption (`/project-02-basic-encryption-decryption`)
* **Goal:** Implements symmetric text obfuscation using the Caesar Cipher mechanism[cite: 2].
* **Key Features:**
  * Uses modular arithmetic ($E_n(x) = (x + n) \pmod{26}$) to shift character byte streams while preserving non-alphabetic formatting[cite: 2].
  * Performs inverse decryption logic ($D_n(x) = (x - n) \pmod{26}$)[cite: 2].
  * Explores vulnerabilities like frequency analysis and small key space (25 shifts)[cite: 2].
* **Java Concepts Used:** Type casting (`char` / `int`), ASCII arithmetic, modular operator `%`.

### 3. Phishing Awareness & Analysis (`/project-03-phishing-awareness-analysis`)
* **Goal:** Automates the parsing and triage of incoming communication lures to identify malicious emails[cite: 3].
* **Key Features:**
  * Inspects sender header anomalies, domain typosquatting, homoglyph attacks, and embedded URL subdomains[cite: 3].
  * Detects cognitive exploit triggers (Urgency, Authority, Fear)[cite: 3].
  * Categorizes threats into actionable triage outcomes: **Safe**, **Warn User**, or **Block & Escalate**[cite: 3].
* **Java Concepts Used:** String parsing, Regex pattern matching, File I/O (`java.nio.file`).

### 4. System Vulnerability Checklist (`/project-04-system-vulnerability-checklist`)
* **Goal:** A proactive system auditor designed to identify endpoint security gaps and misconfigurations[cite: 4].
* **Key Features:**
  * Audits password policies, OS update statuses, guest account privileges, and firewall profile active states[cite: 4].
  * Classifies discovered risks against the CVSS 4.0 metric framework[cite: 4].
  * Generates actionable remediation roadmaps mapped to CIS Controls and NIST standards[cite: 4].
* **Java Concepts Used:** System process execution (`ProcessBuilder`), CLI output parsing, Object-Oriented Data Modeling.

---

## 🚀 How to Run (Java CLI)

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/YOUR_USERNAME/decodelab-cybersecurity-internship.git](https://github.com/YOUR_USERNAME/decodelab-cybersecurity-internship.git)
   cd decodelab-cybersecurity-internship
