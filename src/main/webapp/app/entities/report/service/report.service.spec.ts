import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ReportType } from 'app/entities/enumerations/report-type.model';
import { IReport, Report } from '../report.model';

import { ReportService } from './report.service';

describe('Report Service', () => {
  let service: ReportService;
  let httpMock: HttpTestingController;
  let elemDefault: IReport;
  let expectedResult: IReport | IReport[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(ReportService);
    httpMock = TestBed.inject(HttpTestingController);

    elemDefault = {
      id: 0,
      type: ReportType.CHEAT,
      content: 'AAAAAAA',
      url: 'AAAAAAA',
    };
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = Object.assign({}, elemDefault);

      service.find(123).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(elemDefault);
    });

    it('should create a Report', () => {
      const returnedFromService = Object.assign(
        {
          id: 0,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.create(new Report()).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a Report', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          type: 'BBBBBB',
          content: 'BBBBBB',
          url: 'BBBBBB',
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.update(expected).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a Report', () => {
      const patchObject = Object.assign(
        {
          type: 'BBBBBB',
          content: 'BBBBBB',
          url: 'BBBBBB',
        },
        new Report()
      );

      const returnedFromService = Object.assign(patchObject, elemDefault);

      const expected = Object.assign({}, returnedFromService);

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of Report', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          type: 'BBBBBB',
          content: 'BBBBBB',
          url: 'BBBBBB',
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toContainEqual(expected);
    });

    it('should delete a Report', () => {
      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult);
    });

    describe('addReportToCollectionIfMissing', () => {
      it('should add a Report to an empty array', () => {
        const report: IReport = { id: 123 };
        expectedResult = service.addReportToCollectionIfMissing([], report);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(report);
      });

      it('should not add a Report to an array that contains it', () => {
        const report: IReport = { id: 123 };
        const reportCollection: IReport[] = [
          {
            ...report,
          },
          { id: 456 },
        ];
        expectedResult = service.addReportToCollectionIfMissing(reportCollection, report);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a Report to an array that doesn't contain it", () => {
        const report: IReport = { id: 123 };
        const reportCollection: IReport[] = [{ id: 456 }];
        expectedResult = service.addReportToCollectionIfMissing(reportCollection, report);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(report);
      });

      it('should add only unique Report to an array', () => {
        const reportArray: IReport[] = [{ id: 123 }, { id: 456 }, { id: 19815 }];
        const reportCollection: IReport[] = [{ id: 123 }];
        expectedResult = service.addReportToCollectionIfMissing(reportCollection, ...reportArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const report: IReport = { id: 123 };
        const report2: IReport = { id: 456 };
        expectedResult = service.addReportToCollectionIfMissing([], report, report2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(report);
        expect(expectedResult).toContain(report2);
      });

      it('should accept null and undefined values', () => {
        const report: IReport = { id: 123 };
        expectedResult = service.addReportToCollectionIfMissing([], null, report, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(report);
      });

      it('should return initial array if no Report is added', () => {
        const reportCollection: IReport[] = [{ id: 123 }];
        expectedResult = service.addReportToCollectionIfMissing(reportCollection, undefined, null);
        expect(expectedResult).toEqual(reportCollection);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
