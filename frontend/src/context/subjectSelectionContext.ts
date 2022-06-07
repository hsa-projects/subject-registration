import { SubjectTO } from "@/api";
import React from "react";

interface SubjectSelectionContextType {
    subjectSelection: SubjectTO[],
    setSubjectSelection: (subject: SubjectTO[]) => {}
}

/*
 * Saves the current subject selection of the user throughout the application.
 */
const SubjectSelectionContext = React.createContext<SubjectSelectionContextType | null>(null);

export default SubjectSelectionContext;
