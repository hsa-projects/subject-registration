import {Configuration, RegistrationControllerApi, SubjectControllerApi} from "@/api";

let apiHost = document.location.host
const httpProto = document.location.protocol

if (import.meta.env.VITE_API_HOST !== undefined) {
    apiHost = import.meta.env.VITE_API_HOST as string
}

const apiUrl = `${httpProto}//${apiHost}`

const apicfg = new Configuration({
    basePath: apiUrl,
})

export const SubjectApi = new SubjectControllerApi(apicfg)
export const RegistrationApi = new RegistrationControllerApi(apicfg)
