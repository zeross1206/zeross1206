import { IUser } from 'app/entities/user/user.model';
import { ReportType } from 'app/entities/enumerations/report-type.model';

export interface IReport {
  id?: number;
  type?: ReportType | null;
  content?: string | null;
  url?: string | null;
  user_report?: IUser | null;
}

export class Report implements IReport {
  constructor(
    public id?: number,
    public type?: ReportType | null,
    public content?: string | null,
    public url?: string | null,
    public user_report?: IUser | null
  ) {}
}

export function getReportIdentifier(report: IReport): number | undefined {
  return report.id;
}
