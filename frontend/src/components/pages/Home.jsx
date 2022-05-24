import { RegistrationControllerApi, SubjectControllerApi } from "@/api";
import { useContext, useEffect, useState } from "react";
import userContext from "../../context/userContext";
import SubjectSelectionContext from "../../context/subjectSelectionContext";
import { getRequestHeaders } from "../../util/util";

const IMPRINT_URL = "https://www.hs-augsburg.de/Service/Impressum.html";

/**
 * Main page of the application.
 * @return {JSX.Element}
 * @constructor
 */
function Home() {
  const registrationApi = new RegistrationControllerApi();
  const subjectApi = new SubjectControllerApi();
  const { user, setUser } = useContext(userContext);
  const { subjectSelection, setSubjectSelection } = useContext(
    SubjectSelectionContext
  );

  // initially fetch the registration and subject selection of the logged in user
  useEffect(() => {
    const loadUsers = async () => {
      const userInfo = await user.loadUserInfo();
      setUserInfo(userInfo);
      if (!subjectSelection) {
        const registrationResponse = await registrationApi.getRegistration(
          user.subject,
          getRequestHeaders(user)
        );
        console.log(
          `registrations of user ${user.subject}: ${registrationResponse.data}`
        );
        const registration = registrationResponse.data;
        if (!registration) {
          return;
        }

        const subjectResponse = await subjectApi.getAllSubjects(
          getRequestHeaders(user)
        );
        const userSubjects = [];
        subjectResponse.data.forEach((subject) => {
          registration.subjectSelection.forEach((subjectSelection) => {
            if (subject.id === subjectSelection.subject) {
              let foundSubject = subject;
              foundSubject.priority = subjectSelection.points;
              foundSubject.selectionId = subjectSelection.id;
              userSubjects.push(foundSubject);
            }
          });
        });
        console.log("found subjects");
        console.log(userSubjects);
        setSubjectSelection(userSubjects);
      }
    };

    if (user) {
      loadUsers().catch(console.error);
    }
  }, [user, setUser, subjectSelection, setSubjectSelection]);

  return (
    <>
      <div className="container main">
        <div className="row">
          <h2>Startseite</h2>
          <p>
            Herzlich Willkommen bei der WPF-Anmeldeseite!
            <br />
            Auf der linken Seite finden Sie ale nötigen Informationen zur
            Anmeldung.
          </p>
        </div>
        <div className="row">
          <h2>Anmeldefrist</h2>
          <p>
            Die Anmeldefrist für die Wahlpflichtfächer beginnt am 29.4.2021 und
            endet am 30.05.2021.
          </p>
        </div>
        <div className="row">
          <h2>Kontakt</h2>
          <p>Bei Fragen/Problemen wenden Sie sich bitte an Frau Bäurle.</p>
        </div>
        <div className="row">
          <h2>Impressum</h2>
          <a href={IMPRINT_URL} style={{ marginBottom: "0.5rem" }}>
            Link
          </a>
        </div>
      </div>
    </>
  );
}

export default Home;
