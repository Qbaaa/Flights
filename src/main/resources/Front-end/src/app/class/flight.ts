import {Airport} from "./airport";

export class Flight {

  id: number;
  type: string;
  start: Airport;
  end: Airport;
  startTime: string;
  durationTimeMinutes:number;
  priceForOnePlace: number;
  maxWightBaggageForOnePerson: number;
  feeConst: number;
  feeForKiloPack: number;
}
