import { useParams, useNavigate, Link } from "react-router-dom";
import React, { useContext, useEffect, useState } from "react";
import userContext from "../../context/userContext";
import { SubjectControllerApi, SubjectTO } from "../../api";
import { getRequestHeaders } from "../../util/util";

import Keycloak from "keycloak-js";

const PREVIOUS_PATH_MAP = {
    "/registrations": "Meine Anmeldungen",
    "/subjects": "Übersicht",
};

interface SubjectDetailProps {

}

/**
 * Displays all details of a subject. See RegistrationTableItem.js for a list of all props.
 * @param props
 * @return {JSX.Element}
 * @constructor
 */
function SubjectDetail(props: SubjectDetailProps) {
    const subjectApi = new SubjectControllerApi();
    const { user, setUser } = useContext(userContext);
    const [userInfo, setUserInfo] = useState<Keycloak.KeycloakInstance | null>(null);
    const [subject, setSubject] = useState<SubjectTO>();
    const [previousPath, setPreviousPath] = useState();
    const { name } = useParams();
    let navigate = useNavigate();

    const subjectName = name?.replace("_", " ");

    useEffect(() => {
        const loadUser = async () => {
            const userInfo = await user.loadUserInfo() as any;
            setUserInfo(userInfo);
            console.log("[SubjectDetail] selected subject: " + subjectName);
            console.log("[SubjectDetail] props:");
            // fetch subject info from backend
            const subjectResponse = await subjectApi.getAllSubjects(
                getRequestHeaders(user)
            );
            const subject = subjectResponse.data.find(
                (s) => s.id === subjectName
            );
            setSubject(subject);
        };
        if (user) {
            loadUser().catch(console.error);
        }
    }, [subjectName, user, setUser]);

    /**
     * Navigate to the previous page.
     * @param {MouseEvent} e Instance of the mouse event.
     */
    const goBack = (e: React.SyntheticEvent) => {
        navigate(-1);
        e.preventDefault();
    };

    return (
        <>
            <div className="container main">
                <div className="row" style={{ marginBottom: "0.75em" }}>
                    <p style={{ color: "#F00045" }}>
                        <Link to="/subjects">
                            Übersicht
                        </Link>
                        <span> / </span>
                        <Link to=".">
                            {subject?.name}
                        </Link>
                    </p>
                    <h2 style={{ marginBottom: "0.5em" }}>{subject?.name}</h2>
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
