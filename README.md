# PIIMask: A Data Masking Library for Sensitive Personal Identification Information

[![Build Status](https://github.com/Vicynet/piidatamask/actions/workflows/maven.yml/badge.svg)](https://github.com/Vicynet/piidatamask/actions/workflows/maven.yml)

## Overview

PII Data Mask is a lightweight Java library designed for masking Personally Identifiable Information (PII) fields within Spring Boot applications. It supports customizable masking patterns and easy annotation-based configuration to help developers secure sensitive data.

## Features

- Mask sensitive fields like phone numbers, emails, and credit card numbers.
- Flexible masking patterns, including start, end, middle, and start-end masking.
- Integration with Spring Boot JSON serialization.

## Getting Started

1. **Add Dependency**  
   *Include Maven dependency info here after publishing to Maven Central or GitHub Packages.*

2. **Usage**  
   Annotate fields with `@MaskData` to specify masking options.
