import React, { useState } from 'react'
import '../componentCss/Homepage.css'
import axios from 'axios';


function Homepage() {

  const [artist, setArtist] = useState('');
  const [searchResults, setSearchResults] = useState();
  const [lyrics, setLyrics] = useState();

  function handleChange(e){
    setArtist(e.target.value);
  }

  function handleSubmit(e) {
    e.preventDefault();
    console.log(artist);
    basicSearch();

  }

  const basicSearch = async() => {
    try{
      const res = 
      await axios.get('http://localhost:8080/songs/search/'+artist);
      console.log(res.data.hits);
      setSearchResults([...res.data.hits]);
    } catch (error){
      console.error("Error in Basic Search: ",error);
    }
  };

  const getLyrics = async (songId) => {
    try {
      const lyricsData = await axios.get('http://localhost:8080/songs/lyrics/'+songId); 
      // fetchLyrics(songId);
      console.log(songId);
      console.log(lyricsData.data.lyrics.lyrics.body.html)
      console.log("into lyricsData",lyricsData);
      setLyrics({...lyricsData});
      console.log("into lyrics",lyrics)

      if (lyricsData.data && lyricsData.data.lyrics && lyricsData.data.lyrics.lyrics.body) {
        const newTab = window.open();
        newTab.document.write(`
          <html>
            <head>
              <title>${lyricsData.data.lyrics.tracking_data.title} Lyrics</title>
            </head>
            <body>
              <h2>${lyricsData.data.lyrics.tracking_data.title} Lyrics</h2>
              <p>${lyricsData.data.lyrics.lyrics.body.html}</p>
            </body>
          </html>
        `);
      }else {
          console.error("Lyrics data is not in the expected format:", lyrics);
        }
    } catch (error) {
      console.error("Error fetching lyrics: ", error);
    }
  };


  return (
    <div>
        <h1><span className='title'> Song  <span className='title2'> Flix</span></span></h1>
    <h3 className='content'>
        Get Complete lyrics of any given track.
    </h3>
    <br></br>
    <form className='formfield' onSubmit={handleSubmit}>
      <input type='text' placeholder='Alan Walker' className='searchbox' value={artist} onChange={handleChange}/> 
      <button type='submit' >Search</button>
    </form>

    {searchResults && (
        <div className="results-container">
          <div className="grid-container">
            {searchResults.map((song) => (
              <div key={song.result.id} className="result-item">
                <div className="result-content">
                  <div className="image-container">
                    <span>
                      <img
                        src={song.result.song_art_image_thumbnail_url}
                        className="result-image"
                        alt={song.result.song_art_image_thumbnail_url}
                      />
                    </span>
                  </div>
                  <div className="text-container">
                    <h3 className="result-title">
                      {song.result.title}
                    </h3>
                    <span className="result-artist">
                      {song.result.artist_names}
                    </span>
                    <button
                      className="result-button"
                      onClick={() => {
                        getLyrics(song.result.id);
                      }}
                    >
                      Get Lyrics &rarr;
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      )}
      
      {/* {lyrics && ( */}
        {/* <div className="lyrics-container"> */}
          {/* <h2 className="lyrics-title"> */}
            {/* Lyrics for {lyrics.data.lyrics.tracking_data.title} */}
            {/* lyrics.full_title */}
          {/* </h2> */}
          {/* <p className="lyrics-text"> */}
          {/* lyrics.lyrics.body?.plain */}
            {/* {lyrics.data.lyrics.lyrics.body.html || 'Lyrics not available.'} */}
          {/* </p> */}
        {/* </div> */}
      {/* )} */}

      <div className="attribution-container">
        <p className="attribution-text">
          Made by Nikhil Nandanwar -{' '}
          <a
            className="attribution-link"
            href="https://github.com/CodeForNikhil?tab=repositories"
          >
            See more examples like this
          </a>
        </p>
      </div>
    </div>
  )
}

export default Homepage