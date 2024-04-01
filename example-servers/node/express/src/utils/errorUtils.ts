import {NextFunction, Request, Response} from 'express';

export class ErrorUtils {
  public static handle(error: Error, _: Request, res: Response, next: NextFunction) {
    console.error('Error:', error.message || error);
    // Sends response back to botconversa Chat using the Response format:
    // https://botconversachat.dev/docs/connect/#Response
    res.status(500).send({error: error.message || error});
  }
}
