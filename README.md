# SongFlix Application

## ScreenShots: 

![SongFlix Screenshot](https://github.com/CodeForNikhil/SongFlix/blob/main/FrontEnd%20Code/HomePageSongFlix.png)

![SongFlix Screenshot](https://github.com/CodeForNikhil/SongFlix/blob/6c24e616f07f8b5cdb20cec0673b625fec816daf/FrontEnd%20Code/SearchResultsforSongFlix.png)

## Overview

SongFlix is a web application that allows users to search for information about their favorite artists. The application utilizes a RestAPI built with Spring Boot for fetching artist data, and the frontend is developed using React.

## Features

- User inputs the artist's name in the search bar.
- The application sends a request to the authenticated RestAPI.
- The RestAPI returns artist data in JSON format.
- The JSON data is parsed and filtered in the backend.
- The filtered data is displayed on the frontend using React.

## Technologies Used

- **Frontend:** React
- **Backend:** Spring Boot
- **Data Format:** JSON

## How it Works

1. **User Input:**
   - Users enter the artist's name in the search bar on the SongFlix website.

2. **RestAPI Request:**
   - The frontend sends a request to the authenticated RestAPI with the entered artist's name.

3. **Authentication:**
   - The RestAPI requires proper authentication tokens for data retrieval. Unauthorized requests are denied.

4. **Data Retrieval:**
   - Upon successful authentication, the RestAPI fetches artist data in JSON format.

5. **Backend Processing:**
   - The backend processes the JSON data, applying necessary filters and parsing methods to extract relevant information.

6. **Frontend Display:**
   - The filtered data is then displayed on the SongFlix website using React components.

## Authentication

The RestAPI is secured with authentication to ensure that only authorized users can access the artist's data. Make sure to obtain and include the required authentication token when making requests to the RestAPI.

### How to Obtain Authentication Token

To obtain an authentication token:
1. Register on the RapidAPI website: https://rapidapi.com/hub.
2. Navigate to the search section and Search for Genius API.
3. Subscribe and include the key in the headers of your RestAPI requests inside the SongLyrics file stored in the Backend folder.

## Getting Started

To run the SongFlix application locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/CodeForNikhil/SongFlix
   ```
2. Run the BackEnd code using the appropriate IDE(Eclipse/IntelliJ/STS)

3. Navigate to FrontEnd and run the React Application through VSCode.
