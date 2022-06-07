import { useNavigate, useLocation } from "react-router-dom";
import { URLS } from "@/server_constants";
import SubjectSelectionContext from "../context/subjectSelectionContext";
import React, { useContext } from "react";

const DELETE = "Entfernen";
const INVALID_INPUT = "Eingabe ungültig";

interface RegistrationTableItemProps {

    /**
     * ID of the subject.
     */
    id: string,

    /**
     * Name of the subject. 
     */
    subject: string,

    /**
     * Name of the professor responsible for this subject.
     */
    professor: string,

    /** 
     * Credit points of the subject. 
     */
    creditPoints: number,
    /**
     *  Chosen subject priority of the user.
     */
    priority: number,

    /**
     * Current status of this subject's registration.
     */
    status: string,

    /**
     * Short description of the subject.
     */
    description: string,

    /**
     * Specialization which is associated with 
     */
    specialization: string,
}

function RegistrationTableItem(props: RegistrationTableItemProps) {
    let navigate = useNavigate();
    const location = useLocation();
    const { subjectSelection, setSubjectSelection } = useContext(
        SubjectSelectionContext
    ) || {};

    if (!subjectSelection || !setSubjectSelection) {
        return <></>;
    }

    /**
     * Handle clicks on a subject title. Opens the subject detail page.
     * @param {MouseEvent} e Instance of the mouse event.
     */
    const handleSubjectClick = (e: React.SyntheticEvent) => {
        const link = props.subject.replace(" ", "_");
        console.log(
            `[RegistrationTableItem][handleClick] click on subject ${link}!`
        );
        navigate(`${URLS.SUBJECTS}/${link}`, {
            state: {
                subject: props,
                prevPath: location.pathname,
            },
        });
        e.preventDefault();
    };

    /**
     * Delete the subject from the user's selection.
     * @param {MouseEvent} e Instance of the mouse event.
     */
    const deleteSubject = (e: React.SyntheticEvent) => {
        console.log(`[RegistrationTableItem] delete subject ${props.subject}!`);
        let subjects = Array.from(subjectSelection);
        subjects = subjects.filter((subject) => subject.id !== props.id);
        setSubjectSelection(subjects);
        e.preventDefault();
    };

    return (
        <>
            <tr>
                <td>
                    <a href="/" onClick={(e) => handleSubjectClick(e)}>
                        {props.subject}
                    </a>
                </td>
                <td>{props.professor}</td>
                <td>{props.creditPoints}</td>
                <td style={{ width: "5em" }}>
                    <form className="form-inline">
                        <input
                            id="priority"
                            type="text"
                            style={{ width: "5em" }}
                            defaultValue={props.priority}
                        />
                        <div className="invalid-feedback">{INVALID_INPUT}</div>
                    </form>
                </td>
                <td>{props.status}</td>
                <td>
                    <a href="/" onClick={(e) => deleteSubject(e)}>
                        {DELETE}
                    </a>
                </td>
            </tr>
        </>
    );
}

export default RegistrationTableItem;
