/**
 * Generated by orval v6.7.1 🍺
 * Do not edit manually.
 * OpenAPI definition
 * OpenAPI spec version: v0
 */
/**
 * Data to create a new subject selection
 */
export interface NewSubjectSelectionTO {
  subject: string;
  points: number;
}

/**
 * Data to create a new registration
 */
export interface NewRegistrationTO {
  student: string;
  subjectSelection: NewSubjectSelectionTO[];
}

/**
 * Information to a new registration window
 */
export interface NewRegistrationWindowTO {
  semester: string;
  startDate: string;
  endDate: string;
}

/**
 * Data to create a new subject
 */
export interface NewSubjectTO {
  name: string;
  professor: string;
  creditPoints: number;
  description?: string;
  specialization?: string;
}

/**
 * Information to a specific subject selection
 */
export interface SubjectSelectionTO {
  id: string;
  subject: string;
  points: number;
}

/**
 * Information to a specific registration
 */
export interface RegistrationTO {
  id: string;
  student: string;
  subjectSelection: SubjectSelectionTO[];
}

/**
 * Data to update a registration
 */
export interface RegistrationUpdateTO {
  id: string;
  subjectSelection: SubjectSelectionTO[];
}

/**
 * Information to a specific registration window
 */
export interface RegistrationWindowTO {
  id: string;
  semester: string;
  startDate: string;
  endDate: string;
}

/**
 * Data to update a registration window
 */
export interface RegistrationWindowUpdateTO {
  id: string;
  startDate: string;
  endDate: string;
}

/**
 * Information to a specific subject
 */
export interface SubjectTO {
  id: string;
  name: string;
  professor: string;
  creditPoints: number;
  description?: string;
  specialization?: string;
}

/**
 * Data to update a subject
 */
export interface SubjectUpdateTO {
  id: string;
  professor: string;
  creditPoints: number;
  description?: string;
  specialization?: string;
}

