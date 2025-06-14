// @ts-ignore
import { Doctor } from "../../doctor/model/doctor";

export interface AppointmentDetails {

    id: string;
    patientName: string;
    patientAge: number;
    assignedDoctor: Doctor;
}
