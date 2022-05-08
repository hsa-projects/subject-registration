import "./resources/css/App.css";
import "./resources/css/BurgerMenu.css";
import Home from "./components/pages/Home";
import MyRegistrations from "./components/pages/MyRegistrations";
import StartRegistration from "./components/pages/StartRegistration";
import SubjectOverview from "./components/pages/SubjectOverview";
import SubjectDetail from "./components/pages/SubjectDetail";
import Info from "./components/pages/Info";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { useEffect, useState } from "react";
import userContext from "./context/userContext";
import SubjectSelectionContext from "./context/subjectSelectionContext";
import Keycloak from "keycloak-js";

export const URLS = {
  HOME: "home",
  REGISTRATIONS: "registrations",
  START_REGISTRATION: "startRegistration",
  SUBJECTS: "subjects",
  INFO: "info",
  LOGOUT: "logout",
};

export const MASTER_MAJORS = ["MIN", "BIS", "IMS"];
export const COURSE_CATALOGUE = {
  BACHELOR: "https://cloud.hs-augsburg.de/s/e6bYJTCP4JQ5RXj",
  MASTER: "https://cloud.hs-augsburg.de/s/a7TnPfxtmXbxTcD",
};

const KEYCLOAK_CONFIG = {
  realm: "hsa",
  url: "http://localhost:8080/auth/",
  clientId: "wpf-rest-api",
};

function App() {
  const [user, setUser] = useState(null);
  const [subjectSelection, setSubjectSelection] = useState(null);
  const [keycloak, setKeycloak] = useState(null);
  const [authenticated, setAuthenticated] = useState(false);

  useEffect(() => {
    const createKeycloak = async () => {
      const keycloak = Keycloak(KEYCLOAK_CONFIG);

      await keycloak.init({
        onLoad: "login-required",
        redirectUri: "http://localhost:3000",
      });
      setKeycloak(keycloak);
      setAuthenticated(keycloak.authenticated);
      setUser(keycloak);
    };

    if (!keycloak) {
      // The timeout is needed to prevent an infinite redirect bug when
      // using <StrictMode>, see: https://github.com/react-keycloak/react-keycloak/issues/182
      // In pruduction this should have no noticeable difference, since
      // a timeout with 0 is executed on the next event cycle
      const timer = setTimeout(() => {
        createKeycloak().catch(console.error);
      }, 0);

      return () => {
        clearTimeout(timer);
      };
    }

    return () => {};
  }, []);

  return (
    <>
      {keycloak ? (
        authenticated ? (
          <div>
            <userContext.Provider value={{ user, setUser }}>
              <SubjectSelectionContext.Provider
                value={{ subjectSelection, setSubjectSelection }}
              >
                <Router>
                  <Routes>
                    <Route path="/" element={<Home />} end />
                    <Route
                      path={`/${URLS.REGISTRATIONS}`}
                      element={<MyRegistrations />}
                    />
                    <Route
                      path={`/${URLS.START_REGISTRATION}`}
                      element={<StartRegistration />}
                    />
                    <Route
                      path={`/${URLS.SUBJECTS}`}
                      element={<SubjectOverview />}
                      end
                    />
                    <Route
                      path={`/${URLS.SUBJECTS}/:name`}
                      element={<SubjectDetail />}
                    />
                    <Route path={`/${URLS.INFO}`} element={<Info />} />
                  </Routes>
                </Router>
              </SubjectSelectionContext.Provider>
            </userContext.Provider>
          </div>
        ) : (
          <div>
            <p>Error: Authentication failed!</p>
          </div>
        )
      ) : (
        <div>
          <p>Starting keycloak service...</p>
        </div>
      )}
    </>
  );
}

export default App;
