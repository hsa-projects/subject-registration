import {useContext, useEffect, useState} from "react";
import {SubjectTO} from "@/api";
import Pagination from "../layout/Pagination";
import {COURSE_CATALOGUE} from "@/server_constants";
import SubjectSelectionContext from "../../context/subjectSelectionContext";
import userContext from "../../context/userContext";
import {getRequestHeaders} from "@/util/util";
import {SubjectApi} from "@/util/apis";
import Keycloak from "keycloak-js";

// defines the max. number of subjects that should be shown on one page.
const SUBJECT_LIMIT = 16;
// defines the max. number of page numbers that should be shown on the pagination component.
const PAGE_LIMIT = 4;
const NO_SUBJECTS = "Momentan sind keine Wahlpflichtfächer vorhanden.";

/**
 * Provides an overview of all available subjects.
 */
function SubjectOverview() {
    const { user, setUser } = useContext(userContext);
    const [userInfo, setUserInfo] = useState<Keycloak.KeycloakInstance | null>(null);
    const [subjects, setSubjects] = useState<SubjectTO[] | null>(null);
    const { subjectSelection, setSubjectSelection } = useContext(
        SubjectSelectionContext
    ) || {};

    console.log(userInfo);

    useEffect(() => {
        const loadUser = async () => {
            const userInfo = await user.loadUserInfo() as any;
            setUserInfo(userInfo);
            if (!subjects) {
                console.log("get subjects!");
                const subjectResponse = await SubjectApi.getAllSubjects(
                    getRequestHeaders(user)
                );
                console.log(`got ${subjectResponse.data.length} subjects`);
                console.log(
                    `subject selection of ${userInfo.preferred_username
                    }: ${JSON.stringify(subjectSelection)}`
                );
                setSubjects(subjectResponse.data);
            }
        };
        if (user) {
            loadUser().catch(console.error);
        }
    }, [subjects, user, setUserInfo, subjectSelection, setSubjectSelection]);

    return (
        <>
            <div className="container main">
                <div className="row">
                    <h2 style={{ marginBottom: "0.75em" }}>
                        Übersicht Wahlpflichtfächer
                    </h2>
                    <p>
                        Hier finden Sie alle Wahlpflichtfächer, die in diesem Semester
                        angeboten werden.
                        <br />
                        Wenn Sie sich für einen bestimmten Wahlpflichtfach anmelden möchten,
                        klicken Sie auf 'Anmelden' in der Aktionsleiste.
                        <br />
                        Detaillierte Informationen zu den Wahlpflichtfächern finden Sie im{" "}
                        <a
                            href={
                                // userInfo.degreeCourse is normally read, but doesn't exist
                                COURSE_CATALOGUE.BACHELOR
                            }
                        >
                            Modulhandbuch
                        </a>
                        .
                    </p>
                    {subjects && subjects.length > 0 ? (
                        <Pagination
                            data={subjects}
                            dataLimit={SUBJECT_LIMIT}
                            pageLimit={PAGE_LIMIT}
                        />
                    ) : (
                        <p>{NO_SUBJECTS}</p>
                    )}
                </div>
            </div>
            <br />
        </>
    );
}

export default SubjectOverview;
