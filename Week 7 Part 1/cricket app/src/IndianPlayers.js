import React from 'react';

const IndianPlayers = () => {
  const players = [
    "Rohit", "Virat", "Gill", "Hardik", "Jadeja", 
    "Pant", "Iyer", "Kishan", "Bumrah", "Siraj", "Kuldeep", "Dhoni"
  ];

  const oddTeam = players.filter((_, index) => index % 2 !== 0);
  const evenTeam = players.filter((_, index) => index % 2 === 0);

  const T20players = ["Suryakumar", "Washington", "Umran"];
  const RanjiPlayers = ["Manoj", "Saha", "Mukesh"];
  const allMergedPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        {oddTeam.map((p, index) => <li key={index}>{p}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenTeam.map((p, index) => <li key={index}>{p}</li>)}
      </ul>

      <h2>Merged Players (T20 + Ranji)</h2>
      <ul>
        {allMergedPlayers.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
