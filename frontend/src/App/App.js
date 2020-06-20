import React, { useState } from 'react';
import SuperTitle from '../Headings/SuperTitle';
import Register from '../Register/Register';
import {wrapWithPageLayout, wrapWithNarrowPageLayout} from '../Layout/layouts';
import './App.css';

const REGISTER = 'Registration';
const GET_INFO = 'Retrieve information';
const EDIT_INFO = 'Edit information';

function App() {
  const [screen, setScreen] = useState(null);

  let screenHtml;
  if (screen === REGISTER) {
    screenHtml = wrapWithNarrowPageLayout(REGISTER, <Register />);
  }
  if (screen === GET_INFO) {
    screenHtml = <div>GET_INFO</div>;
  }
  if (screen === EDIT_INFO) {
    screenHtml = <div>EDIT_INFO</div>;
  }

  return (
    <div className="contapp">
      <header className="contapp-menu">
        <SuperTitle text="Contapp Sandbox" />
        <div className="features">
          <button className="link" onClick={() => setScreen(REGISTER)}>
            Register
          </button>
          <button className="link" onClick={() => setScreen(GET_INFO)}>
            Get Info
          </button>
          <button className="link" onClick={() => setScreen(EDIT_INFO)}>
            Edit Info
          </button>
        </div>
      </header>

      <div className="contapp-main">{screenHtml}</div>
    </div>
  );
}

export default App;
