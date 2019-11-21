import { TestBed, inject } from '@angular/core/testing';

import { PointsService } from './points.service';

describe('PointsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PointsService]
    });
  });

  it('should be created', inject([PointsService], (service: PointsService) => {
    expect(service).toBeTruthy();
  }));
});
