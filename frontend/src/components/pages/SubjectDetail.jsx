import { useParams, useNavigate } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import userContext from "../../context/userContext";
import { SubjectControllerApi } from "@/api";
import { getRequestHeaders } from "../../util/util";

const PREVIOUS_PATH_MAP = {
  "/registrations": "Meine Anmeldungen",
  "/subjects": "Übersicht",
};

/**
 * Displays all details of a subject. See RegistrationTableItem.js for a list of all props.
 * @param props
 * @return {JSX.Element}
 * @constructor
 */
function SubjectDetail(props) {
  const subjectApi = new SubjectControllerApi();
  const { user, setUser } = useContext(userContext);
  const [userInfo, setUserInfo] = useState(null);
  const [subject, setSubject] = useState();
  const [previousPath, setPreviousPath] = useState();
  const { name } = useParams();
  let navigate = useNavigate();

  const subjectName = name.replace("_", " ");

  useEffect(() => {
    const loadUser = async () => {
      const userInfo = await user.loadUserInfo();
      setUserInfo(userInfo);
      console.log("[SubjectDetail] selected subject: " + subjectName);
      console.log("[SubjectDetail] props:");
      console.log(props.location.state);
      if (props.location.state) {
        setSubject(props.location.state.subject);
        console.log(
          `[SubjectDetail] previous URL: ${props.location.state.prevPath}`
        );
        setPreviousPath(props.location.state.prevPath);
      } else {
        // fetch subject info from backend
        const subjectResponse = await subjectApi.getAllSubjects(
          getRequestHeaders(user)
        );
        const subject = subjectResponse.data.find(
          (s) => s.name === subjectName
        );
        setSubject(subject);
      }
    };
    if (user) {
      loadUser().catch(console.error);
    }
  }, [props.location.state, subjectName, user, setUser]);

  /**
   * Navigate to the previous page.
   * @param {MouseEvent} e Instance of the mouse event.
   */
  const goBack = (e) => {
    navigate(-1);
    e.preventDefault();
  };

  return (
    <>
      <div className="container main">
        <div className="row" style={{ marginBottom: "0.75em" }}>
          <p style={{ color: "#F00045" }}>
            <a href="." onClick={(e) => goBack(e)}>
              {previousPath
                ? PREVIOUS_PATH_MAP[previousPath]
                : PREVIOUS_PATH_MAP["/subjects"]}
            </a>{" "}
            / <a href="/">{subjectName}</a>
          </p>
          <h2 style={{ marginBottom: "0.5em" }}>{subjectName}</h2>
          {/* todo correct link */}
          <p>
            Detailliertere Informationen finden Sie im{" "}
            <a href="/">Modulhandbuch.</a>
          </p>
        </div>
        <div className="row">
          <table className="table">
            <tbody className="subject-detail">
              <tr>
                <th scope="row">Dozent</th>
                <td>{subject ? subject.professor : ""}</td>
              </tr>
              <tr>
                <th scope="row">Credit Points</th>
                <td>{subject ? subject.creditPoints : ""}</td>
              </tr>
              <tr>
                <th scope="row">Beschreibung</th>
                <td>{subject ? subject.description : ""}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}

export default SubjectDetail;
