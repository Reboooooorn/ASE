import {ICountry} from "../country/ICountry";

export interface IManufacturer {
  id: number,
  name: string,
  country: ICountry
}
